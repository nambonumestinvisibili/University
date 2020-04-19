#ifndef WYRAZENIA_HPP_INCLUDED
#define WYRAZENIA_HPP_INCLUDED
#include <iostream>
#include <string>
#include <vector>
#include <math.h>
using namespace std;

class wyrazenie{

    public:
        virtual double oblicz() = 0;
        virtual string opis() = 0;

};

class liczba : public wyrazenie{
    private:
        bool lewostronna = false;
        int priorytet = 1;

    public:
        double wartosc;
        inline liczba(double val){ wartosc = val;};
        inline string opis() {return to_string(wartosc);};
        inline double oblicz() {return wartosc;};

};


class stala : public wyrazenie{

    protected:
        bool lewostronna = false;
        int priorytet = 1;
    private:
        string nazwa;
        double wartosc;

    public:
        //stala(string nazwa, double wartosc);
        inline string opis() {return to_string(wartosc);};
        inline double oblicz() {return wartosc;};

};

class pi : public stala {
    double wartosc = 3.14;
    string nazwa = "pi";

    public:
        pi() {};
        inline string opis() {return nazwa;};
        inline double oblicz() {return wartosc;};

};

class fi: public stala {
    double wartosc = 1.618;
    string nazwa = "fi";

    public:
        fi() {};
        inline string opis() {return nazwa;};
        inline double oblicz() {return wartosc;};
};

class e : public stala {
    double wartosc = 2.71;
    string nazwa = "e";

    public:
        inline e() {};
        inline string opis() {return nazwa;};
        inline double oblicz(){return wartosc;};

};



class zmienna : public wyrazenie{
    private:
        static vector<pair<string, double>> wartosciowanie;
    protected:
        bool lewostronna = false;
        int priorytet = 1;
    public:
        static void dodaj(string nazwa, double wartosc);
        static void wydrukuj();

        string nazwa;
        zmienna(string nazwa){this->nazwa = nazwa;};

        double oblicz();
        string opis(){return nazwa;};
};

class operator1arg : public wyrazenie {
    protected:
        wyrazenie * sub;
        bool lewostronna = false;
        int priorytet = 2;
    public:
        operator1arg(wyrazenie* wyraz){sub = wyraz;};
};


class sinus : public operator1arg {
    public:
        sinus(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(){return "sin(" + this->sub->opis() + ")";};
        double oblicz() {return sin(sub->oblicz());}
};


class cosinus : public operator1arg {
    public:
        cosinus(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(){return "cos(" + this->sub->opis() + ")";};
        double oblicz() {return cos(sub->oblicz());}

};

class exponent : public operator1arg {
    public:
        exponent(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(){return "exponent(" + this->sub->opis() + ")";};
        double oblicz() {return exp(sub->oblicz());}

};

class ln : public operator1arg {
    public:
        ln(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(){return "ln(" + this->sub->opis() + ")";};
        double oblicz() {return log(sub->oblicz());}

};

class bezwzgl : public operator1arg {
    public:
        bezwzgl(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(){return "|" + this->sub->opis() + "|";};
        double oblicz() {return abs(sub->oblicz());}

};

class przeciw : public operator1arg {
    public:
        przeciw(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(){return "-(" + this->sub->opis() + ")";};
        double oblicz() {return -1*(sub->oblicz());}

};

class odwrot : public operator1arg {
    public:
        odwrot(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(){return "(1/(" + this->sub->opis() + "))";};
        double oblicz() {return 1/(sub->oblicz());}

};



class operator2arg : public operator1arg{
    protected:
        wyrazenie *sub2;
        bool lewostronna = 0;
        int priorytet = 3;
    public:
        operator2arg(wyrazenie *wyraz1, wyrazenie* wyraz2) : operator1arg(wyraz1) {this->sub = wyraz1; this->sub = wyraz2;};

};

class dodawanie : public operator2arg {
    protected:
        bool lewostronna = true;
        int priorytet = 4;
    public:
        dodawanie(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {};
        string opis();
        double oblicz() {return sub->oblicz() + sub2->oblicz();};

};
class odejmowanie : public operator2arg {
    protected:
        bool lewostronna = true;
        int priorytet = 4;
    public:
        odejmowanie(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {};
        string opis();
        double oblicz() {return sub->oblicz() - sub2->oblicz();};

};













#endif // WYRAZENIA_HPP_INCLUDED
