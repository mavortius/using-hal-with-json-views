package com.example

import grails.rest.Resource

@Resource(readOnly = true, uri = '/api/orders')
class Order {
    String orderId
    BigDecimal shippingCost
    Date orderPlaned = new Date()
    Address shippingAddress

    static hasMany = [ products : Product ]

    static belongsTo = [ customer : Customer ]

    static constraints = {
    }

    static mapping = {
        table 'CUS_ORDER'
    }

    BigDecimal getTotalPrice() {
        return shippingCost + products*.price.sum()
    }
}
