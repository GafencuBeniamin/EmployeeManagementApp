package utcn.departmentManager.SCD_proiect.exceptions;

public class CrudOperationException extends RuntimeException{
    public CrudOperationException(String message){
        super(message);
    }
}
