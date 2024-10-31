package co.edu.umanizales.kids_list.controller;

@restcontroller
@requestmapping("/listse")
public class listSEcontroller
{
    @getmapping
    public string hello(){
        return "hello world";
    }
}
