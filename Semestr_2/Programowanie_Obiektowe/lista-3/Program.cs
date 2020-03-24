using System;

namespace Collect
{
    class Program
    {
        static void Main(string[] args)
        {
            Lista<int> lis = new Lista<int>();
            lis.Append(1);
            lis.Append(2);
            lis.Append(3);
            lis.Append(4);
            Console.WriteLine(lis.get(2));

            lis.RemoveIndex(2);
            lis.Print();



            Slownik<string, int> dic = new Slownik<string, int>();
            dic.Add("ja", 21);
            dic.Add("ty", 20);
            dic.Add("on", 19);
            dic.Add("ona", 18);
            dic.Print();
            dic.RemoveKey("ja");
            dic.Print();
            Console.WriteLine(dic.Find("ty"));
            dic.RemoveKey("on");
            dic.RemoveKey("ona");
            dic.RemoveKey("ty");
            dic.Print();
            
        }
    }

    public class Lista<T>
    {
        class Element
        {
            public T value;
            public Element next;
            public Element prev;

            public Element(T val)
            {
                this.next = null;
                this.value = val;
                this.prev = null;
            }

        }

        Element first;
        Element last;
        int rozmiar;

        public Lista()
        {
            this.first = null;
            this.last = null;
            rozmiar = 0;
        }

        public void Print()
        {
            if (first == null)
            {
                Console.WriteLine("[]");
            }
            else
            {
                Console.Write("[");
                Element el = first;
                while(el != null)
                {
                    Console.Write(el.value + ",");
                    el = el.next;
                }
                Console.WriteLine("\b]");
            }
        }
        public void Append(T wal)
        {
            Element newelem = new Element(wal);

            if (first == null)
            {
                first = newelem;
                last = first;
            }
            else if (first.next == null)
            {
                last = newelem;
                first.next = last;
                last.prev = first;

            }
            else
            {
                last.next = newelem;
                newelem.prev = last;
                last = newelem;
                
            }
            rozmiar++;

        }
        public T Pop()
        {
            if (first == null)
            {
                throw new System.IndexOutOfRangeException();
            }
            if (first.next == null)
            {
                T g = first.value;
                first = null;
                rozmiar = 0;
                return g;
            }
            
            T temp = last.value;
            last = last.prev;
            last.next = null;
            rozmiar--;
            return temp;
            
        }
        public void Enqueque(T wal)
        {

            Element newel = new Element(wal);
            if (first == null)
            {
                first = newel;
            }
            else
            {
                newel.next = first;
                first.prev = newel;
                first = newel;
            }
            rozmiar++;

        } // dodac case bases
        public T Dequeue()
        {
            if (first == null)
            {
                throw new System.IndexOutOfRangeException();
            }
            if (first.next == null)
            {
                T g = first.value;
                first = null;
                rozmiar = 0;
                return g;
            }

            T wal = first.value;
            first = first.next;
            rozmiar--;
            return wal;
        }
        public T get(int idx)
        {
            if (idx < 0 || idx >= rozmiar)
            {
                throw new System.IndexOutOfRangeException();
            }
            else {
                int temp = 0;
                Element aux = first;
                while (aux != null)
                {
                    if (temp == idx)
                    {
                        break;
                    }
                    temp++;
                    aux = aux.next;
                }
                return aux.value;
            }
        }
        public int Len()
        {
            return rozmiar;
        }
        public void RemoveIndex(int index)
        {
            
            if (index >= 0 || index < rozmiar)
            {
                if (index == 0)
                {
                    if (rozmiar == 1)
                    {
                        T result = first.value;
                        first = null;
                        last = first;
                        rozmiar--;
                        
                    }
                    else
                    {
                        T result = first.value;
                        first = first.next;
                        rozmiar--;
                        
                    }

                }
                else if (index == rozmiar - 1)
                {
                    T result = last.value;
                    last = last.prev;
                    last.next = null;
                    rozmiar--;
                    
                } 
                else
                {
                    Element current = first;
                    int i = 0;
                    while(current != null)
                    {
                        if (i == index)
                        {
                            T result = current.value;
                            Element previous = current.prev;
                            Element nexxxt = current.next;
                            previous.next = nexxxt;
                            nexxxt.prev = previous;
                            rozmiar--;
                            
                            break;
                        }
                        current = current.next;
                        i++;
                    }
                }
                
                
            }
            else
            {
                throw new System.IndexOutOfRangeException();
            }
        }
        

        
}

    public class Slownik<Key, Value> where Key : IComparable<Key>
    {
        
        Lista<Key> keys;
        Lista<Value> vals;
        int rozmiar;

        public Slownik()
        {
            keys = new Lista<Key>();
            vals = new Lista<Value>();
            rozmiar = 0;
        }

        public void Add(Key ky, Value va)
        {
            keys.Append(ky);
            vals.Append(va);
            rozmiar++;
        }

        public void Print()
        {
            Console.WriteLine("{");
            for (int i = 0; i< (keys.Len()); i++)
            {
                Console.WriteLine("[" + keys.get(i) + ": " + vals.get(i) + "], ");
            }
            Console.WriteLine("}");
        }

        public void RemoveKey(Key napis)
        {
            int count = 0;
            for (int i = 0; i < keys.Len(); i++)
            {
                if (napis.CompareTo(keys.get(i)) == 0)
                {
                    break;
                }
                count++;

            }
            keys.RemoveIndex(count);
            vals.RemoveIndex(count);
        }

        public Value Find(Key k)
        {
            for (int i = 0; i < keys.Len(); i++)
            {
                if(k.CompareTo(keys.get(i)) == 0)
                {
                    return vals.get(i);
                }
            }
            throw new System.Exception();

        }







    }

}
