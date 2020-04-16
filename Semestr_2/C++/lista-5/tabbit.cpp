#include "tabbit.hpp"
using namespace std;

//Klasa ref:
void tab_bit::ref::SetBit(uint64_t * tab, int bitidx){
    int i = bitidx/rozmiarSlowa;
    int pos = bitidx%rozmiarSlowa;

    unsigned int flag = 1; //flag = 0000...00001
    flag = flag << pos;    //flag = 00000...1000

    tab[i] = tab[i] | flag;
}

void tab_bit::ref::ClearBit(uint64_t * tab, int bitidx){
    int i = bitidx/rozmiarSlowa;
    int pos = bitidx%rozmiarSlowa;

    unsigned int flag = 1;

    flag = flag << pos;
    flag = ~flag;

    tab[i] = tab[i] & flag;

}

bool tab_bit::ref::GetBit(uint64_t * tab, int bitidx){
    int i = bitidx/rozmiarSlowa;
    int pos = bitidx%rozmiarSlowa;

    return (tab[i] & (1<<pos));
}

//Pomocnicze:
bool tab_bit::czytaj(int i) const {
    tab_bit::ref aux;
    bool odp = aux.GetBit(this->tab, i);
    return odp;
}

bool tab_bit::pisz(int idx, bool value){
    tab_bit::ref aux;
    if (value == true) aux.SetBit(tab, idx);
    else aux.ClearBit(tab, idx);
    return true;
}

//G³ówny konstruktor:
tab_bit::tab_bit(int rozmiar){
    if (rozmiar < 0) throw invalid_argument("Rozmiar musi byc dodatni");
    dl = rozmiar;
    int ile = ceil(rozmiar/rozmiarSlowa)+1;
    tab = new slowo[ile];

    for(int i = 0; i < ile; i++) tab[i] = 0;


}

//Wypisywanie:
ostream & operator << (ostream &wy, const tab_bit &tb){
    for(int i = 0; i < tb.dl; i++) wy << tb.czytaj(i);
    wy << " " << endl;
    return wy;
}

int tab_bit::rozmiar () const {return dl;}

//Konstruktory przypisania i kopiowania:

tab_bit::tab_bit (const tab_bit &tb){
    dl = tb.dl;
    if(tab) delete[] tab;
    tab = new slowo[dl];
    for (int i = 0; i < tb.dl; i++){
        tab[i] = tb.tab[i];
    }
}

tab_bit::tab_bit (tab_bit && tb){
    dl = tb.dl;
    if(tab) delete[] tab;
    tab = new slowo[dl];
    for (int i = 0; i < tb.dl; i++){
        tab[i] = tb.tab[i];
    }
    tb.dl = 0;
    tb.tab = nullptr;

}

//Odpowiednie operatory przypisania:
tab_bit & tab_bit::operator = (const tab_bit &tb){
    if (this != &tb){
        dl = tb.dl;
        if(tab) delete[] tab;
        tab = new slowo[dl];
        for (int i = 0; i < tb.dl; i++){
        tab[i] = tb.tab[i];
    }





    }
    return *this;

}

tab_bit & tab_bit::operator = (tab_bit &&tb){
    dl=tb.dl;
    tab=tb.tab;
    tb.dl=0;
    tb.tab=nullptr;
    return *this;
};

//Destruktor:
tab_bit::~tab_bit (){
    dl = 0;
    delete [] tab;
}

//Indeksator
bool tab_bit::operator[](int i) const
{
   return czytaj(i);
}

//Zaprzyjaznione operacje bitowe:

tab_bit operator | (const tab_bit &u, const tab_bit &v){
    int maxidx = max(u.dl, v.dl);
    int minidx = min(u.dl, v.dl);

    tab_bit result(maxidx);
    for (int i = 0; i< minidx; i++){
        if(u[i] == true || v[i] == true) result.pisz(i,true);
        else result.pisz(i, false);
    }

    return result;

}

tab_bit operator & (const tab_bit &u, const tab_bit &v){
    int maxidx = max(u.dl, v.dl);
    int minidx = min(u.dl, v.dl);
    tab_bit result(maxidx);

    for (int i = 0; i < minidx; i++){
        if (u[i] == true && v[i] == true) result.pisz(i, true);
        else result.pisz(i, false);
    }
    return result;
}

tab_bit operator ^ (const tab_bit &u, const tab_bit &v){
    int maxidx = max(u.dl, v.dl);
    int minidx = min(u.dl, v.dl);
    tab_bit result(maxidx);

    for (int i = 0; i < minidx; i++){
        if (u[i] != v[i]) result.pisz(i, true);
        else result.pisz(i, false);
    }
    return result;

}



tab_bit tab_bit::operator!(){
    for (int i = 0; i < dl; i++){
        if (tab[i] == true) pisz(i, false);
        else pisz(i, true);
    }
    return *this;
}


tab_bit& tab_bit::operator&=(const tab_bit &v){

    *this = *this & v;
    return *this;


}

tab_bit& tab_bit::operator|=(const tab_bit &v){

    *this = *this | v;
    return *this;


}

tab_bit& tab_bit::operator^=(const tab_bit &v){

    *this = *this ^ v;
    return *this;


}
