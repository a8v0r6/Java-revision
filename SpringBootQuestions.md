1. ConditionalOnProperty

2. Default scope of Spring beans 
    default scope is singelton
    other scopes are Prototype, Request, Session, Application, Websocket

3. How to inject bean optionally?
    
    ```
    @Autowired(required = false)
    ```

4. How to store List of string with jpa

    ```
    @ElementCollection
    private List<Strings> list;
    ```

    if it is list of entities then we have to use `@OneToMany`, `@ManyToOne`, ElementCollection

5. How to persist child entity with parent?

    Use cascade type all or persist

| Cascade Type | Behavior |
|--------------|----------|
| PERSIST | When you save the parent, all associated children are also saved. |
| MERGE | If you update a detached parent, the changes are propagated to the children. |
| REMOVE | If you delete the parent, all associated children are deleted from the database. |
| REFRESH | Reloads the state of the parent and its children from the database. |
| DETACH | Removes both parent and children from the Hibernate session (persistence context). |
| ALL | A shorthand that applies all of the above operations. | 

6. How to handle exception in a class and globally

    Use `@ExceptionHandler` 

    ```
    @ExceptionHandler(ResourceNotFoundException.class) 
    ResponseEntity<?> handleException() { ... }
    ```
    
    Use `@ControllerAdvice` and `@ExceptionHandler`

7. Which annotations `@SpringBootApplication` combine?
    `@Configuration`, `@EnableAutoConfiguration` and `@ComponentScan`

8. how do you force immediate loading of child entity with parent?
    
    a. `@EntityGraph` - creates eager fetch type just for a particular method
    b. Fetch.Type = eager - fetches eagerly for all calls
    
9. How to rollback for specific exceptions
    
    ```
    @Transactional(rollbackFor = {SQLException.class, MyCustomException.class})
    ```
10. How do you control Json field names in responses?
    
    ```
    @JsonProperty("user-id")
    private UUID id;
    ```


