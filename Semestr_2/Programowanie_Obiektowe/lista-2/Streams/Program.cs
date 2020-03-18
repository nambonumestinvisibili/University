using System;

namespace Streams
{
    class Program
    {
        static void Main(string[] args)
        {

            RandomWordStream slowo = new RandomWordStream();
            Console.WriteLine("Randomowe slowa");
     
            Console.WriteLine(slowo.next());
            Console.WriteLine(slowo.next());
            Console.WriteLine(slowo.next());
            Console.WriteLine(slowo.next());

            PrimeStream prime = new PrimeStream();
            Console.WriteLine("\n\nPrimeStream:");
            Console.Write(prime.next() + " ");
            Console.Write(prime.next() + " ");
            Console.Write(prime.next() + " ");
            Console.Write(prime.next() + " \n\n");

            IntStream integers = new IntStream();
            Console.WriteLine("IntStream:");
            
            for (int i = 0; i<20; i++)
            {
                Console.Write(integers.next() + ", ");
                if (i == 3)
                {
                    integers.reset();
                }
            }
                       
        }

        class IntStream
        {
            protected int licznik;

            public IntStream()
            {
                licznik = -1;
            }

            virtual public int next()
            {
                if (licznik == Int32.MaxValue)
                 {
                    return -1;
                 }
                else
                {
                    return ++licznik;
                }
                
            }

            virtual public bool eos()
            {
                if (Int32.MaxValue == licznik)
                    return true;
                else
                    return false;
            }

            virtual public void reset()
            {
                this.licznik = -1;
            }



            
        }

        class PrimeStream : IntStream
            
        {
            
            private bool czy_pierwsza(int licznik)
            {
                if (licznik < 2) return false;

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

            public override int next()
            {
                if (licznik == Int32.MaxValue)
                    return -1;
                licznik++;
                while (czy_pierwsza(licznik) != true && licznik < Int32.MaxValue)
                {
                        licznik++;
                }
                if (licznik == Int32.MaxValue)
                    return -1;
                else 
                    return licznik;
            }

            public override void reset()
            {
                licznik = -1;
            }
        }
        
        class RandomStream: IntStream

        {
            private Random rand;

            public RandomStream()
            {
               rand = new Random();
            }
            public override int next()
            {
                return rand.Next(0, Int32.MaxValue);
            }
            public override bool eos()
            {
                return false;
            }
            

        }

        class RandomWordStream
        {
            private PrimeStream prime;
            private RandomStream rand;
            

            public RandomWordStream()
            {
                prime = new PrimeStream();
                rand = new RandomStream();
                
            }

            public string next()
            {

                string result = "";

                

                
                int pierwsza = prime.next();
                for (int i = 0; i < pierwsza; i++)
                {
                    result += randchar();
                }

                
                return result;

            }

            private char randchar()
            {
                int ile = rand.next() % 26;
                return (char)('a' + ile);
            }

        }
    }

}
