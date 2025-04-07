/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import java.time.LocalDateTime;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.acme.transaction.model.Transaction;

/**
 *
 * @author aaron
 */
@ApplicationScoped
public class TransactionRepository implements PanacheMongoRepository<Transaction>{
    public List<Transaction> finByAccount(String account){
        return list("account",account);
    }
    
    public List<Transaction> findTxByAccountDate(String account, LocalDateTime date){
        return find("account=?1 and date=?2", account, date).list();
    }
    public List<Transaction> findByDEscription(String desc){
        String regex="(?i).*"+desc+".*s";
        return find("description like ?1", regex).list();
    }
}
