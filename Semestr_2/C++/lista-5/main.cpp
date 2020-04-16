#include "tabbit.hpp"

int main()
{

tab_bit t(46); // tablica 46-bitowa (zainicjalizowana zerami)
//tab_bit u(46); // tablica 64-bitowa (sizeof(uint64_t)*8)
tab_bit v(t); // tablica 46-bitowa (skopiowana z t)
//tab_bit w(tab_bit(8){1, 0, 1, 1, 0, 0, 0, 1}); // tablica 8-bitowa (przeniesiona)
//v[0] = true; // ustawienie bitu 0-go bitu na 1
//t[45] = true; // ustawienie bitu 45-go bitu na 1
bool b = v[1]; // odczytanie bitu 1-go
//u[45] = u[46] = u[63]; // przepisanie bitu 63-go do bitow 45-go i 46-go
cout<<t<<endl; // wysietlenie zawartoœci tablicy bitów na ekranie

tab_bit alfa(3);
alfa.pisz(0, true);
alfa.pisz(2, true);

tab_bit beta(3);
beta.pisz(2, true);
cout << "alfa i beta:" << endl;
cout << alfa << "\n" << beta << endl;

cout << "alfa&beta" << endl;
tab_bit ro = alfa & beta;
cout << ro;
cout << "alfa|beta" << endl;
tab_bit gamma = alfa | beta;
cout << gamma;
cout << "alfa^beta" << endl;
tab_bit chi = alfa ^ beta;
cout << chi;
cout << "beta|=alfa" << endl;
beta |= alfa;
cout << beta;
cout << "beta^=alfa" << endl;
beta ^= alfa;
cout << beta;
cout << "beta&=alfa" << endl;
beta &= alfa;
cout << beta;


}
