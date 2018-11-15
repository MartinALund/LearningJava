package Exceptions;

public class CustomException extends Exception {
    public static final long serialVersionUID = 42L;

    @Override
    public String getMessage() {
        return "Custom exception!";
    }
}

/*
    int a = 1;
    int b = 2;

        try {
                if (a > b){
                }else{
                throw new CustomException();
                }
                } catch (CustomException e) {
                e.printStackTrace();
                }

                */