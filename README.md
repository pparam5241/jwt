# jwt
Description branch wise

# master branch
In the master branch, we have JWT Token generation using In Memory User which we're configurating manually by creating beans of UserDetailsService provided by Spring Security.
Here, We don't have any such database configuration for authentication.

# db branch
In db branch, We have JWT Token Generation using MySQL Database in which we've created User table and added Two User using CommandLineRunner in the Starting of the application.
We've encrypted the password using BCryptPasswordEncoder provided by Spring Security and it is recommended to use as well.
For Verifying the user using Database instead of In Memory User, We need to override configure method using AuthenticationManagerBuilder and need to pass our CustomUserDetailsService object with passwordEncoder.
Also we need to create custom Class for UserDetails and Custom Class for UserDetailsService as well for Fetching UserDetails and use of loadUserFromUserDetails function Override purpose.

Apart from this, Rest of the details will be common for all two branches.

# update
First Build -> 1.0.0
If I'll found any updates here, then I'll provide it and share here with update sections.
