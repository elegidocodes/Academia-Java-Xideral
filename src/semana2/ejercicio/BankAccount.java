package semana2.ejercicio;

class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {

    private final double deficit;

    public InsufficientBalanceException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}

class AccountLockedException extends Exception {

    public AccountLockedException(String message) {
        super(message);
    }
}

class TransactionLog implements AutoCloseable {

    private boolean open = true;

    public void log(String string) {
        if (!open) throw new IllegalStateException("Log cerrado");
        System.out.println("Log: " + string);
    }

    @Override
    public void close() throws Exception {
        open = false;
        System.out.println("Log: transaction log closed");
    }
}

public class BankAccount {
    private double balance;
    private boolean locked;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.locked = false;
    }

    static void main(String[] args) {
        BankAccount cuenta1 = new BankAccount(1000.00);
        BankAccount cuenta2 = new BankAccount(500.00);

        // Operaciones válidas
        try {
            cuenta1.deposit(500);
            System.out.printf("Deposito exitoso. Saldo: $%.2f%n", cuenta1.getBalance());

            cuenta1.withdraw(200);
            System.out.printf("Retiro exitoso. Saldo: $%.2f%n", cuenta1.getBalance());

            cuenta1.transfer(cuenta2, 300);
            System.out.printf("Transferencia exitosa. Saldo cuenta1: $%.2f, cuenta2: $%.2f%n",
                    cuenta1.getBalance(), cuenta2.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (AccountLockedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Manejo de Errores ===");

        try {
            cuenta1.deposit(-100);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (AccountLockedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            cuenta1.withdraw(999999);
        } catch (InsufficientBalanceException e) {
            System.out.printf("Error: %s (deficit: $%.2f)%n", e.getMessage(), e.getDeficit());
        } catch (AccountLockedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Prueba de cuenta bloqueada (Quería probar la exception de bloqueo)
        /* System.out.println("\n=== Cuenta Bloqueada ===");

        try {
            cuenta1.lock();
            cuenta1.deposit(100);
        } catch (AccountLockedException e) {
            System.out.println("Error deposito: " + e.getMessage());
        }

        try {
            cuenta1.withdraw(50);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (AccountLockedException e) {
            System.out.println("Error retiro: " + e.getMessage());
        }

        try {
            cuenta1.transfer(cuenta2, 100);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (AccountLockedException e) {
            System.out.println("Error transferencia: " + e.getMessage());
        }*/
    }

    public void deposit(double amount) throws AccountLockedException {
        if (locked) throw new AccountLockedException("La cuenta está bloqueada");
        if (amount <= 0) throw new InvalidAmountException("Monto invalido: " + amount);
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, AccountLockedException {
        if (locked) throw new AccountLockedException("La cuenta está bloqueada");
        if (amount <= 0) throw new InvalidAmountException("Monto invalido: " + amount);
        if (amount > balance)
            throw new InsufficientBalanceException(
                    "Fondos insuficientes para retirar $" + String.format("%.2f", amount),
                    amount - balance
            );
        balance -= amount;
    }

    public void transfer(BankAccount target, double amount)
            throws InsufficientBalanceException, AccountLockedException {
        try (TransactionLog log = new TransactionLog()) {
            withdraw(amount);
            log.log(String.format("Retiro de $%.2f de cuenta origen. Saldo: $%.2f", amount, balance));
            target.deposit(amount);
            log.log(String.format("Deposito de $%.2f en cuenta destino. Saldo: $%.2f", amount, target.balance));
        } catch (InsufficientBalanceException | AccountLockedException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void lock() {
        this.locked = true;
    }

    public double getBalance() {
        return balance;
    }
}