package com.company;

public class Operations extends Expression {

        Expression w1;
        Expression w2;
        String operand;

        Operations(String operation, Expression e1, Expression e2){
            if (operation == "/" && e2.evaluate() == 0)
                throw new IllegalArgumentException("Argument divisor is 0 :(");
            w1 = e1;
            w2 = e2;
            operand = operation;

        }

        public int evaluate(){
            switch (operand){
                case "+":
                    return w1.evaluate() + w2.evaluate();
                case "-":
                    return w1.evaluate() - w2.evaluate();
                case "*":
                    return w1.evaluate() * w2.evaluate();
                case "/":
                    return w1.evaluate() / w2.evaluate();
                default:
                    throw new IllegalArgumentException("Operand not supported");

            }
        }

        public String toString() {
            switch (operand) {
                case "+":
                    return "(" + w1 + " + "  + w2 + ") ";
                case "-":
                    return "(" + w1 +" - "  + w2+ ") ";
                case "*":
                    return "(" + w1 + " * " +  w2 + ") ";
                case "/":
                    return "(" + w1 + " / "  + w2 + ") ";
                default:
                    throw new IllegalArgumentException("Operand not supported");
            }
        }



}
