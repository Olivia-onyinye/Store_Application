package com.holyviastores.model;

import java.util.*;

public class Store {
    private List<Product> productList = new ArrayList<>();

    private List<Applicant> applicantList = new ArrayList<>();

    private List<Object> staffList = new ArrayList<>();
    private Queue<Customer> fifo = new LinkedList<>();
    private Queue<Customer> queueList = new PriorityQueue<>(new CustomerOrderComparator());



    public Store(List<Product> productList, List<Applicant> applicantList, List<Object> staffList,
                 PriorityQueue<Customer> queueList, LinkedList<Customer> fifo) {
        this.productList = productList;
        this.applicantList = applicantList;
        this.staffList = staffList;
        this.queueList = queueList;
        this.fifo = fifo;
    }

    public Store () {

    }

    public List<Product> getProductList() {

        return productList;
    }

    public Queue<Customer> getQueueList() {
        return queueList;
    }

    public List<Applicant> getApplicantList() {

        return applicantList;
    }

    public List<Object> getStaffList() {

        return staffList;
    }

    public Queue<Customer> getFifo() {
        return fifo;
    }
}


