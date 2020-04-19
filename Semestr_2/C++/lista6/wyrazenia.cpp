#include "wyrazenia.hpp"
#include <iostream>
#include <algorithm>

vector<std::pair<std::string, double>> zmienna::wartosciowanie;


void zmienna::dodaj(string nazwa, double wartosc){

    vector<string> aux;
    for (auto elem: zmienna::wartosciowanie) aux.push_back(elem.first);

    if (count(aux.begin(), aux.end(), nazwa)) throw invalid_argument("Zmienna juz istnieje");

    zmienna::wartosciowanie.push_back(pair<string, double>(nazwa, wartosc));
}


void zmienna::wydrukuj(){

    for (auto elem : zmienna::wartosciowanie){
        cout << elem.first << " = " << elem.second << endl;
    }

    return;
}

double zmienna::oblicz(){

    for (unsigned int i = 0; i < zmienna::wartosciowanie.size(); i++){
        if( zmienna::wartosciowanie[i].first.compare(nazwa) == 0){
            return zmienna::wartosciowanie[i].second;
        }
    }

    throw invalid_argument("Nie mam takiej zmiennej");
}


//----------------------------------------------------------------------
//Operatory 1arg
//----------------------------------------------------------------------







