/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.acme.repository.TransactionRepository;
import org.acme.transaction.model.Transaction;
import org.jboss.logging.Logger;
/**
 *
 * @author aaron
 */
@Path("/transactions")
@Consumes("Application/json")
@Produces("Application/json")
public class TransactionResource {
    Logger logger= Logger.getLogger(TransactionResource.class);

    @Inject
    TransactionRepository repository;

    @POST
    public Transaction addTransaction(Transaction tx){
        repository.persist(tx);
        return tx;
    }
}
