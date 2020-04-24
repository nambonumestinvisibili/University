klucz = { "a" => "b", "b" => "r", "r" => "y",
        "y" => "u", "u" => "a"}

alfabet = "cdefghijklmnopstwz".split("")
alfabetSize = alfabet.size 
i = 1


alfabet.each do |char|
    klucz[char] = alfabet[alfabetSize-i]
    i+=1
end 

class Jawna
    def initialize(msg)
        @message = msg
    end 

    def zaszyfruj(klucz)
        result = ""        
        @message.split("").each do |sign|
            result += klucz[sign]
        end 

        res = Zaszyfrowana.new(result)
        return res 
    end 

    def to_str
        @message
    end
end 
        
        


class Zaszyfrowana
    def initialize(szyfr)
        @szyfr = szyfr 
    end 
    def to_str
        @szyfr 
    end

    def odszyfruj(klucz)
        odwrKlucz = klucz.invert
        res = ""
        @szyfr.split("").each do |char|
            res += odwrKlucz[char]
        end
        result = Jawna.new(res)
        return result 
    end
end

test = Jawna.new("ruby")
puts test.to_str
szyfrTest = test.zaszyfruj(klucz)
puts szyfrTest.to_str
backToOrig = szyfrTest.odszyfruj(klucz).to_str 
puts backToOrig
