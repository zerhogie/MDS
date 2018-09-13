/*
 * The MIT License
 * 
 * Copyright (c) 2018 Enrique Rodríguez Castañeda
 * 
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom 
 * the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package probandotesis;

/**
 *
 * @author Enrique Rodríguez Castañeda (Zerhogie)
 */
public class ProbandoTesis {
    public int sumarNumeritos(int a, int b) {
        return a + b;
    }
    public int restaNumeritos(int a, int b) {
        return a - b;
    }
    public String pareaNumeritos(int a, int b, int c) {
        String x = String.valueOf(a) + String.valueOf(c) + String.valueOf(b);
        String res = "";
        for(int i = 0; i<x.length(); i++) {
            if(Integer.parseInt(new String("" + x.charAt(i))) % 2 == 0) {
                res = res + x.charAt(i);
            }
        }
        return res;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new ProbandoTesis().sumarNumeritos(10, 5));
        System.out.println(new ProbandoTesis().restaNumeritos(10, 5));
        System.out.println(new ProbandoTesis().pareaNumeritos(25,32,67));
    }
}