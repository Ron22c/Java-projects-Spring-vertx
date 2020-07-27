package shop;

public class Door {
    private Lock lock;
    public Door() {
        this.lock = new Lock(true);
    }

    public Lock getLock() {
        return this.lock;
    }

    public void shopStatus() {
        if(lock.isLock()) {
            System.out.println("Shop is closed");
        } else {
            System.out.println("Shop is open");
        }
    }

    public class Lock {
        private boolean lock;
        public Lock(boolean lock) {
            this.lock=lock;
        }

        public boolean isLock() {
            return this.lock;
        }

        public void setLock(boolean value) {
            this.lock=value;
        }
    }
}
