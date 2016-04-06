package concurrent.example.example6;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class RWDictionary {
  private final Map<String, String> m = new TreeMap<String, String>();
  private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
  private final Lock r = rwl.readLock();
  private final Lock w = rwl.writeLock();

  public String get(String key) {
    System.out.println(".get(" + key + ") lock");
    r.lock();
    System.out.println(".get(" + key + ") locked");
    try {
      return m.get(key);
    } finally {
      System.out.println(".get(" + key + ") unlock");
      r.unlock();
      System.out.println(".get(" + key + ") unlocked");
    }
  }

  public String put(String key, String value) {
    System.out.println(".put(" + key + ") lock");
    w.lock();
    System.out.println(".put(" + key + ") locked");
    try {
      return m.put(key, value);
    } finally {
      System.out.println(".put(" + key + ") unlock");
      w.unlock();
      System.out.println(".put(" + key + ") unlocked");
    }
  }
}
