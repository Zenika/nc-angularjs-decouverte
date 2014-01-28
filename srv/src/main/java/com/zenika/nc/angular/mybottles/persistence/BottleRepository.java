package com.zenika.nc.angular.mybottles.persistence;

import com.zenika.nc.angular.mybottles.domain.Bottle;
import restx.factory.Component;

import javax.inject.Named;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Named("bottleRepository")
public class BottleRepository {
    private final static Map<Integer, Bottle> bottles = Collections.synchronizedMap(new HashMap<Integer, Bottle>());
    private final static AtomicInteger counter = new AtomicInteger(1);

    public BottleRepository() {
        if( bottles.isEmpty() ) {
            putBottle(new Bottle("Karma Tripel", "Pays : Belgique", 5));
            putBottle(new Bottle("Liffe", "Pays : Belgique", 4));
            putBottle(new Bottle("Grimberger", "Pays : Belgique", 3));
            putBottle(new Bottle("1337", "Pays : France", 1));
        }
    }

    private Bottle putBottle(Bottle bottle) {
        bottle.setId(counter.getAndIncrement());
        bottles.put(bottle.getId(), bottle);
        return bottle;
    }

    public Collection<Bottle> getAll() {
        return bottles.values();
    }

    public Bottle get(int bottleId) {
         try  {
             return bottles.get(bottleId);
         }catch (Exception e) {
             return null;
         }
    }

    public Bottle edit(Bottle bottle) {
        if( bottles.containsKey(bottle.getId()) ) {
            bottles.put(bottle.getId(), bottle);
            return bottle;
        }
        return null;
    }

    public Bottle save(Bottle bottle) {
        return putBottle(bottle);
    }

    public Bottle remove(int bottleId) {
        return bottles.remove(bottleId);
    }
}
