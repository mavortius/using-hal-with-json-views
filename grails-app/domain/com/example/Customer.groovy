package com.example

import grails.rest.Resource

@Resource(readOnly = true, uri = '/api/customers')
class Customer {
    String firstName
    String lastName

    Address address

    static hasMany = [ orders : Order ]

    static constraints = {
        orders nullable: true
    }
}
