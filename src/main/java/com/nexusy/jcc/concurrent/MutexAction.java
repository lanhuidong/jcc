package com.nexusy.jcc.concurrent;

import com.nexusy.jcc.function.Action;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lanhuidong
 * @since 2022-02-19
 */
public class MutexAction<ID> {

    private final ConcurrentHashMap<ID, ID> lock = new ConcurrentHashMap<>();

    public boolean checkAndDo(ID id, Action action) {
        if (lock.putIfAbsent(id, id) == null) {
            try {
                action.doAction();
            } finally {
                lock.remove(id);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAndDo(ID id, Action action, Action whenConflict) {
        if (lock.putIfAbsent(id, id) == null) {
            try {
                action.doAction();
            } finally {
                lock.remove(id);
            }
            return true;
        } else {
            whenConflict.doAction();
            return false;
        }
    }

}
