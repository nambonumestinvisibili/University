#include <iostream>
#include <ostream>
#include <math.h>

using namespace std;
class tab_bit
{
        typedef uint64_t slowo; // komorka w tablicy
        static const int rozmiarSlowa = 8*sizeof(int64_t); // rozmiar slowa w bitach


        //friend istream & operator >> (istream &we, tab_bit &tb);
        friend ostream & operator << (ostream &wy, const tab_bit &tb); //OK!

        class ref{ //OK!
            public:
                void SetBit(uint64_t * tab, int bitidx);
                void ClearBit(uint64_t * tab, int bitidx);
                bool GetBit(uint64_t * tab, int bitidx);

        }; // klasa pomocnicza do adresowania bitów;

    protected:
        int dl; // liczba bitów
        slowo *tab; // tablica bitów

    public:
        explicit tab_bit (int rozm); // wyzerowana tablica bitow [0...rozm]
        //explicit tab_bit (slowo tb); // tablica bitów [0...rozmiarSlowa]

// zainicjalizowana wzorcem
        tab_bit (const tab_bit &tb); // konstruktor kopiuj¹cy
        tab_bit (tab_bit &&tb); // konstruktor przenosz¹cy
        tab_bit & operator = (const tab_bit &tb); // przypisanie kopiuj¹ce
        tab_bit & operator = (tab_bit &&tb); // przypisanie przenosz¹ce
        ~tab_bit (); // destruktor

    public: //oOK!
        bool czytaj (int i) const; // metoda pomocnicza do odczytu bitu
        bool pisz (int i, bool b); // metoda pomocnicza do zapisu bitu

    public:
        bool operator[] (int i) const; // indeksowanie dla sta³ych tablic bitowych
        //ref operator[] (int i); // indeksowanie dla zwyk³ych tablic bitowych
        inline int rozmiar () const; // rozmiar tablicy w bitach

    public:
        // operatory bitowe: | i |=, & i &=, ^ i ^= oraz !
        tab_bit operator ! ();
        tab_bit& operator &= (const tab_bit &v);
        tab_bit& operator |= (const tab_bit &v);
        tab_bit& operator ^= (const tab_bit &v);

        friend tab_bit operator ^ (const tab_bit &u, const tab_bit &v);
        friend tab_bit operator | (const tab_bit &u, const tab_bit &v);
        friend tab_bit operator & (const tab_bit &u, const tab_bit &v);



    public:
        // zaprzyjaŸnione operatory strumieniowe: << i >>
};
