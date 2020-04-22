#include "wyrazenia.hpp"
#include <iostream>
#include <algorithm>

vector<std::pair<std::string, double>> zmienna::wartosciowanie;
//-----------------------------------------------------------

void zmienna::dodaj(string nazwa, double wartosc){

    for (auto& var : wartosciowanie)
            {
                if (var.first == nazwa)
                    throw invalid_argument("Zmienna juz istnieje");
            }
    zmienna::wartosciowanie.push_back(pair<string, double>(nazwa, wartosc));
}

void zmienna::zmien_wartosc(string nazwa, double val){

    for (auto& var : wartosciowanie){
        if (var.first == nazwa){
            var.second = val;
            return;
        }
    }
    throw new invalid_argument("Nie ma takiej zmiennej");

}

void zmienna::wydrukuj(){

    for (auto &elem : zmienna::wartosciowanie){
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


//-----------------------------------------------------------

string operator2arg::pom_opis(string znak){
    string result = "";
    //cout << this->priorytet << endl;
    if (sub->get_priorytet() <= this->get_priorytet()){
        result += ("(" + sub->opis() + ")");
    }
    else result += sub->opis();

    result += " " + znak + " ";

    if (sub2->get_priorytet() <= this->get_priorytet()){
        result += ("(" + sub2->opis() + ")");
    }
    else result += sub2->opis();


    return result;
}

double dzielenie::oblicz() {
    if (sub2->oblicz() == 0) throw new invalid_argument("Drugie wyrazenie oblicza sie do 0");
    return sub->oblicz() / sub2->oblicz();};

double modulo::oblicz(){
    if (sub2->oblicz() == 0) throw new invalid_argument("Dzielnik oblicza siê do 0");
    return fmod(sub->oblicz(), sub2->oblicz());

}

string przeciw::opis(){
    if (sub->get_priorytet() > 10) return "-" + sub->opis();
    return "-(" + this->sub->opis() + ")";
}

string odwrot::opis(){
    if (sub->get_priorytet() > 10) return "1/" + sub->opis();
    return "1/(" + this->sub->opis() + ")";
}
