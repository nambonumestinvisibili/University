#include <iostream>
#include "wyrazenia.hpp"


using namespace std;

int main()
{
    //odwrotnosc przeciwnosc opis, modulo i logarytm both
    string x = "x";
    string y = "y";
    zmienna::dodaj("x", 0);
    zmienna::dodaj("y", 0);

    wyrazenie *a = new dzielenie(
                                 new mnozenie(
                                              new odejmowanie(
                                                              new zmienna(x),
                                                              new liczba(1)),
                                              new zmienna(x)),
                                 new liczba(2));

    cout << a->opis() << endl;

    wyrazenie *b = new dzielenie(
                                 new dodawanie(new liczba(3),
                                               new liczba(5)),
                                 new dodawanie(new liczba(2),
                                               new mnozenie(new zmienna(x),
                                                            new liczba(7))));

    cout << b->opis() <<endl;

    wyrazenie *c = new odejmowanie(new dodawanie(new liczba(2),
                                                 new mnozenie(new zmienna(x),
                                                              new liczba(7))),
                                   new dodawanie(new mnozenie(
                                                              new zmienna(y),
                                                              new liczba(3)),
                                                 new liczba(5)));

    cout << c->opis() <<endl;

    wyrazenie *d = new dzielenie(new cosinus(
                                             new mnozenie(
                                                          new dodawanie(
                                                                        new zmienna(x),
                                                                        new liczba(1)),
                                                          new zmienna(x))),
                                 new exponent(new potegowanie(
                                                          new zmienna(x), new liczba(2))));
    cout << d->opis() << endl;


    cout << "\n\n";

    for (double i = 0; i <= 1; i+=0.01){
        zmienna::zmien_wartosc(x, i);
        cout << "a: " << a->oblicz() << "\t\t";
        cout << "b: " << b->oblicz() << "\t\t";
        cout << "c: " << c->oblicz() << "\t\t";
        cout << "d: " << d->oblicz() << "\t\t";
        cout << endl;
    }

//    wyrazenie *e = new pi();
//    wyrazenie *f = new odejmowanie(new liczba(5), new liczba(5));
//    wyrazenie *g = new mnozenie(new liczba(5), new liczba(5));
//    wyrazenie *h = new dzielenie(new liczba(5), new liczba(5));
//
//    cout << e->get_priorytet();
//    cout << f->get_priorytet();
//    cout << g->get_priorytet();
//    cout << h->get_priorytet();
}
