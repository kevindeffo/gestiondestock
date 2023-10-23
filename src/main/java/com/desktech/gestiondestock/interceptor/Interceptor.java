package com.desktech.gestiondestock.interceptor;

import jakarta.persistence.Embeddable;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;

import java.io.Serializable;

public class Interceptor implements org.hibernate.Interceptor, Serializable {
    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        org.hibernate.Interceptor.super.beforeTransactionCompletion(tx);
    }
}
