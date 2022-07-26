package com.example.vuminhhieuteam2be.Service;

import java.util.List;

public interface IBaseService<T,M,K> {
    List<T> getAll();

    T getByID(K id);

    T insertNew(M m);

    T updateOld(M m);

    boolean deleteOld(K id);
}
