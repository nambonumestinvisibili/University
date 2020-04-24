

class Fixnum
    def czynniki
        czyn = []
        pierw = Math.sqrt(self).to_i
        i = 1
        while i <= pierw
            if self % i == 0
                if i == self/i 
                    czyn.push(i)
                else
                    czyn.push(i)
                    czyn.push(self/i)
                end
            end
            i+=1
        end
        return czyn.sort 
    end

    def ack(y)
        if self == 0
            return y+1
        elsif y == 0
            return (self-1).ack(1)
        else 
            return (self-1).ack(self.ack(y-1))
        end
    end

    def slownie
        result = ""
        dict = Hash["1" => "jeden ", "2"=> "dwa ", "3" => "trzy ", "4" => "cztery ", "5" => "piec ", "6" => "szesc ", "7" => "siedem ", 
        "9" => "dziewiec ", "8" => "osiem ", "0" => "zero "]

        self.to_s.split('').each do |char|
            result += dict[char]
        end 
        return result
    end

    def doskonala
        size = self.czynniki.length
        a = self.czynniki[0..size-2]
        return a.sum == self
    end




end


puts "Czynniki liczby 6"
puts 6.czynniki 
puts "Czy 6 jest doskonala?"
puts 6.doskonala
puts "wynik 2.ack(1)"
puts 2.ack(1)
puts "123 slownie:"
puts 123.slownie 
