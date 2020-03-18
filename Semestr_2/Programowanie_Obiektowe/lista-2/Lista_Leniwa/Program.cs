using System;
using System.Collections.Generic;


namespace ListaLeniwa
{
    class Program
    {
        static void Main(string[] args)
        {
            Lista_Leniwa lista = new Lista_Leniwa();
            Console.WriteLine("Dlugosc listy:  " + lista.size());
            lista.element(100);
            Console.WriteLine("Element nr 100: " + lista.element(100));
            Console.WriteLine("Element nr 10:  " + lista.element(10));
            lista.element(10);
            Console.WriteLine("Element nr 10:  " + lista.element(10));
            Console.WriteLine("Dlugosc listy:  " + lista.size());
            lista.element(102);
            Console.WriteLine("Element nr 102: "  + lista.element(102) + " Dlugosc: " + lista.size());

            Lista_Primow lista2 = new Lista_Primow();
            lista.element(10);
            for (int i = 0; i <= 10; i++)
            {
                Console.WriteLine(lista2.element(i));
            }
         }

        class Lista_Leniwa
        {
            public List<int> lista;
            protected int licznik;
            

            public Lista_Leniwa()
            {
                lista = new List<int>();
                licznik = 0;
            }

            public int size()
            {
                return licznik;
            }

            public virtual int element(int liczba)
            {
                int rozmiar = this.size();
                if (liczba <= rozmiar)
                {
                    return lista[liczba-1];
                }
                else
                {
                    int g = liczba - rozmiar;
                    Random rand = new Random();
                    for (int i = 0; i < g; i++)
                    {
                        lista.Add(rand.Next());
                    }
                    licznik = liczba;
                }
                
                return lista[liczba-1];
            }
        }
        class PrimeStream

        {
            private int licznik;
            public PrimeStream()
            {
                licznik = 1;
            }

            private bool czy_pierwsza(int licznik)
            {
                double g = Math.Sqrt(licznik);
                for (int i = 2; i <= g; i++)
                {
                    if (licznik % i == 0)
                    {
                        return false;
                    }
                }
                return true;
            }

            public int next()
            {
                
                licznik++;
                while (czy_pierwsza(licznik) != true)
                {
                    licznik++;
                }
                return licznik;
            }

        }
        class Lista_Primow : Lista_Leniwa
        {
            protected PrimeStream pr;

            public Lista_Primow()
            {
                lista = new List<int>();
                licznik = 0;
                pr = new PrimeStream();

            }
            public override int element(int liczba)
            {
                int rozmiar = this.size();
                if (liczba == 0)
                {
                    lista.Add(2);
                    pr.next();
                }
                if (liczba <= rozmiar)
                {
                    return lista[liczba];
                }
                else
                {
                    int g = liczba - rozmiar;

                    PrimeStream prime = new PrimeStream();

                    

                    for (int i = 0; i < g; i++)
                    {
                        lista.Add(pr.next());
                    }
                    
                }
                licznik = liczba;
                return lista[liczba];
            }


        }
    }
}
