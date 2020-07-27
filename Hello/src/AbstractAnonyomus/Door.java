package AbstractAnonyomus;

public class Door {
    private Lock l = new Lock() {
        @Override
        public boolean isLocked(String key) {
            if(key.equals("qwerty")) {
                return false;
            } else {
                return true;
            }
        }
    };

    public boolean isLocked(String key) {
        return l.isLocked(key);
    }
}
