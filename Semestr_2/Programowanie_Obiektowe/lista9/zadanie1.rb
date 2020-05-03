class Funkcja
    def initialize(proc)
        if proc.instance_of?(Proc)
            @procedure = proc
        else
            raise 'Not a procedure'
        end
    end

    def value(x)
        return @procedure.call(x)
    end

    def derivative(point)
        delta = 0.000000001
        return (value(point+delta)-value(point))/delta
    end

    def zeroes(a,b, eps)
        fa = value(a)
        fb = value(b)
        mid = (a+b).to_f/2
        fmid = value(mid)
        #puts fmid
        if fa.abs < eps
            #puts "a"
            return fa
        elsif fb.abs < eps
            #puts 'b'
            return fb
        elsif fmid.abs < eps
            #puts 'c'
            return mid
        elsif fa*fmid < 0
            #puts 'd'
            return zeroes(a, mid, eps)
        elsif fmid*fb < 0
            #puts fmid, fb, mid, b
            #puts 'e'
            return zeroes(mid, b, eps)
        else
            #puts 'f'
            return nil
        end
    end

    def field(a, b)
        n = 100
        interval = (b-a).to_f/n
        result = 0
        result += value(a)/2
        result += value(b)/2
        for i in (1...n) do
            result += value(a + i * interval)
        end
        return interval*result
    end

    def plot(a, b, n_wsp)
        eps = 1
        #n_wsp = 10
        n = (a-b).abs.to_f*n_wsp
        xs = []
        ys = []
        dx = (b-a).to_f/n
        
        (0..n).each do |i|
            xs.push((a+i*dx))
            ys.push(value(xs[i]))
            #puts(i-1 ,ys[i-1])
        end
        
        

        xs.reverse.each do |j|
            print(j.round(2), "\t")
            xs.each do |i|
                if (value(i).round(eps) == j)
                    print("|xxx\t")
                else
                    print("| \t")
                end
            end
            puts()
        end



        print("\t")
        for x in xs do
            if x < 0
                print("|", x.round(2), "\t")
            else
                print("|", x.round(2), "\t")
            end
        end
    end

end



f1 = Funkcja.new( proc {|x| 2*x.abs})

puts "x**2 na przedziale [-0,5; 1.5]"
f2 = Funkcja.new(proc {|x| (x**2)})
f2.plot(-0.5, 1.5, 10)

puts "sinx na przedziale [-0,5; 1.5]"
f3 = Funkcja.new(proc {|x| Math.sin(x)})
f3.plot(-0.5, 1.5,10)

puts ""
print "O funkcji |x|:\n wartosc w 1: ", f1.value(1), "\n"
print "Pochodna w punkcie 3: ", f1.derivative(3), "\n"
print "Miejsce zerowe na [-10, 10] z eps 0.01: ", f1.zeroes(-10, 10, 0.01), "\n"
print "Pole pod wykresem na [0,10]: ", f1.field(0,10), "\n"
puts "Wykres |x| na [-2,9]"
f1.plot(-4,8,1)
