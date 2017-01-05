package bookstore

class BootStrap {

    def init = { servletContext ->

    	// Create roles: admin and user
    	def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
    	def userRole = new Role(authority: 'ROLE_USER').save(failOnError: true)

    	def testUser = new User(username: 'ana', password: '123456').save(failOnError: true)

    	// Create relationship between user and role
    	UserRole.create testUser, adminRole

    	// We explicitly flush (using withSession) because BootStrap 
    	// does not run in a transaction or OpenSessionInView.
    	UserRole.withSession {
    		it.flush()
    		it.clear()
    	}

    	assert User.count() == 1
    	assert Role.count() == 2
    	assert UserRole.count() == 1

    }
    def destroy = {
    }
}
