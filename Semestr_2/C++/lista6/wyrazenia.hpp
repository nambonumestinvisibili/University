#ifndef WYRAZENIA_HPP_INCLUDED
#define WYRAZENIA_HPP_INCLUDED
#include <iostream>
#include <string>
#include <vector>
#include <math.h>
using namespace std;

class wyrazenie{

    public:
        virtual double oblicz()     = 0;
        virtual string opis()       = 0;
        virtual int get_priorytet() = 0;

};

//---------------------------------------

class liczba : public wyrazenie{
    private:
        int priorytet = 11;
        double wartosc;
    public:
        inline liczba(double val)    {wartosc = val;};
        inline string opis()         {return to_string(wartosc);};
        inline double oblicz()       {return wartosc;};
        inline int get_priorytet()   {return priorytet;};


};


//---------------------------------------

class stala : public wyrazenie{

    protected:
        int priorytet = 11;
    private:
        string nazwa;
        double wartosc;

    public:
        //stala(string nazwa, double wartosc);
        inline string opis()          {return to_string(wartosc);};
        inline double oblicz()        {return wartosc;};
        inline int get_priorytet()    {return priorytet;};

};

class pi : public stala {
    double wartosc = 3.14;
    string nazwa = "pi";

    public:
        pi() {};
        inline string opis()       {return nazwa;};
        inline double oblicz()     {return wartosc;};
        inline int get_priorytet() {return priorytet;};
};

class fi: public stala {
    double wartosc = 1.618;
    string nazwa = "fi";

    public:
        fi() {};
        inline string opis()            {return nazwa;};
        inline double oblicz()          {return wartosc;};
        inline int get_priorytet()      {return priorytet;};
};

class e : public stala {
    double wartosc = 2.71;
    string nazwa = "e";

    public:
        inline e() {};
        inline string opis()        {return nazwa;};
        inline double oblicz()      {return wartosc;};
        inline int get_priorytet()  {return priorytet;};

};

//---------------------------------------

class zmienna : public wyrazenie{
    private:
        static vector<pair<string, double>> wartosciowanie;
        int priorytet = 11;
    public:
        static void dodaj(string nazwa, double wartosc);
        static void wydrukuj();
        static void zmien_wartosc(string nazwa, double val);
        string nazwa;
        zmienna(string nazwa)    {this->nazwa = nazwa;};

        double oblicz();
        inline string opis()            {return nazwa;};
        inline int get_priorytet()      {return priorytet;};

};

//---------------------------------------

class operator1arg : public wyrazenie {
    protected:
        wyrazenie * sub;
        int priorytet = 11;
    public:
        operator1arg(wyrazenie* wyraz)   {sub = wyraz;};
        inline int get_priorytet()       {return priorytet;};

};

class sinus : public operator1arg {
    public:
        sinus(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        inline string opis()      {return "sin(" + this->sub->opis() + ")";};
        inline double oblicz()    {return sin(sub->oblicz());}
};

class cosinus : public operator1arg {
    public:
        cosinus(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        inline string opis()       {return "cos(" + this->sub->opis() + ")";};
        inline double oblicz()     {return cos(sub->oblicz());}

};

class exponent : public operator1arg {
    public:
        exponent(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        inline string opis()      {return "exponent(" + this->sub->opis() + ")";};
        inline double oblicz()    {return exp(sub->oblicz());}

};

class ln : public operator1arg {
    public:
        ln(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        inline string opis()    {return "ln(" + this->sub->opis() + ")";};
        inline double oblicz()  {return log(sub->oblicz());}

};

class bezwzgl : public operator1arg {
    public:
        bezwzgl(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        inline string opis()        {return "|" + this->sub->opis() + "|";};
        inline double oblicz()      {return abs(sub->oblicz());}

};

class przeciw : public operator1arg {
    public:
        przeciw(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis();//       {return "-(" + this->sub->opis() + ")";};
        inline double oblicz()     {return -1*(sub->oblicz());}

};

class odwrot : public operator1arg {
    public:
        odwrot(wyrazenie* wyraz) : operator1arg(wyraz) {} ;
        string opis(); //{return "(1/(" + this->sub->opis() + "))";};
        inline double oblicz() {return 1/(sub->oblicz());}

};

//---------------------------------------

class operator2arg : public operator1arg{
    protected:
        int priorytet;
        wyrazenie* sub2;
    public:
        operator2arg(wyrazenie *wyraz1, wyrazenie* wyraz2) : operator1arg(wyraz1) {this->sub = wyraz1; this->sub2 = wyraz2;};
        inline int get_priorytet()                                                {return priorytet;};
        string pom_opis(string znak);
};

class dodawanie : public operator2arg {
    protected:
        int priorytet = 4;
    public:
        dodawanie(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {};
        inline string opis()        {return pom_opis("+");};
        inline double oblicz()      {return sub->oblicz() + sub2->oblicz();};
        inline int get_priorytet()  {return priorytet;};

};

class odejmowanie : public operator2arg {
    protected:
        int priorytet = 5;
    public:
        odejmowanie(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {};
        inline string opis()        {return pom_opis("-");};
        inline double oblicz()      {return sub->oblicz() - sub2->oblicz();};
        inline int get_priorytet()  {return priorytet;};

};

class mnozenie : public operator2arg {
protected:
    int priorytet = 6;
public:
    mnozenie(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {};
    inline string opis()       {return pom_opis("*");};
    inline double oblicz()     {return sub->oblicz() * sub2->oblicz();};
    inline int get_priorytet() {return priorytet;};

};

class dzielenie : public operator2arg {
protected:
    int priorytet = 7;
public:
    dzielenie(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {if (sub2->oblicz() == 0) throw new invalid_argument("Dzielnik oblicza siê do 0");};
    inline string opis()       {return pom_opis("/");};
    double oblicz();
    inline int get_priorytet() {return priorytet;};

};

class potegowanie : public operator2arg {
protected:
    int priorytet = 10;
public:
    potegowanie(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {};
    inline string opis()       {return pom_opis("^");};
    inline double oblicz()     {return pow(sub->oblicz(), sub2->oblicz());};
    inline int get_priorytet() {return priorytet;};

};

class modulo : public operator2arg {
protected:
    int priorytet = 9;
public:
    modulo(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {if (w2->oblicz() == 0) throw new invalid_argument("Dzielnik oblicza siê do 0");};
    inline string opis()     {return pom_opis("%");};
    double oblicz();//   {return fmod(sub->oblicz(), sub2->oblicz());};
    inline int get_priorytet() {return priorytet;};

};

class logarytm : public operator2arg {
protected:
    int priorytet = 9;
public:
    logarytm(wyrazenie *w1, wyrazenie *w2) : operator2arg(w1, w2) {if (w1->oblicz() <= 0 || w2->oblicz() <= 0) throw new invalid_argument("Dzielnik oblicza siê do 0");};
    inline string opis()       {return pom_opis("%");};
    double oblicz()            {return log(sub->oblicz()) / log(sub2->oblicz());};
    inline int get_priorytet() {return priorytet;};

};













#endif // WYRAZENIA_HPP_INCLUDED
