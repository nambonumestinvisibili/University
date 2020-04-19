#include <iostream>
#include "wyrazenia.hpp"


using namespace std;

int main()
{
    wyrazenie *nowa = new liczba(5);
    cout << nowa->oblicz() << endl;

    wyrazenie *st = new pi();
    cout << st->oblicz() << endl;
    cout << st->opis();

    zmienna::dodaj("x", 10);
    zmienna::wydrukuj();
    zmienna::dodaj("y", 11);
    zmienna::wydrukuj();

    wyrazenie *a = new zmienna("x");
    cout << a->oblicz() << endl;


    wyrazenie *c = new przeciw ( new ln ( new odwrot ( new bezwzgl (new cosinus(new zmienna("x"))))));
    cout << c->opis();
    cout << c->oblicz();


}
