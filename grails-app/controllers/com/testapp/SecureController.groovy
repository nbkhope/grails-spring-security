package com.testapp

import grails.plugin.springsecurity.annotation.Secured

// You can annotate the entire controller or individual actions

// @Secured('ROLE_ADMIN')
class SecureController {

	@Secured('ROLE_ADMIN')
    def index() { 
    	render "This is restricted area."
    }
}
