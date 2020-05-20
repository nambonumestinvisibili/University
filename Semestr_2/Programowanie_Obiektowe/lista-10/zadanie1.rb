require 'Time'


class Node
    @value
    #@pprev
    @pnext
    def initialize(val)
        @value = val
        #@pprev = nil
        @pnext = nil
    end

    def to_s()
        return "Node of value: " + @value.to_s
    end

    attr_accessor :value, :pnext #:pprev,
end

class LinkedList
    @first
    @length
    #@last

    def len()
        return @length
    end

    def initialize()
        @first = nil
        @last = nil
        @length = 0
    end

    def to_s()
        copy = @first
        result = "["

        while copy.pnext != nil
            result += copy.to_s + ", "
            copy = copy.pnext
        end

        result += copy.to_s
        result += "]"

        return result
    end

    def insert(val)
        newnode = Node.new(val)

        if @length == 0
            @first = newnode
            @last = @first
        elsif @length == 1
            @first.pnext = newnode
            @last = newnode
        else
            @last.pnext = newnode
            @last = @last.pnext
        end
        @length += 1
    end

    def swap(i, j)
        if i >= @length || j >= @length || i < 0 || j < 0
            raise IndexError
        end

        ival = get(i)
        jval = get(j)

        ii = 0
        jj = 0

        copy = @first
        while ii != i
            copy = copy.pnext
            ii += 1
        end
        copy.value = jval

        copy2 = @first
        while jj != j
            copy2 = copy2.pnext
            jj += 1
        end
        copy2.value = ival
    end

    def get(idx)
        if idx >= @length || idx <0
            raise TypeError("Index out of bound")
        end

        i = 0
        copy = @first

        while i != idx
            copy = copy.pnext
            i += 1
        end

        return copy.value
    end

    def set(idx, to)
        if idx >= @length || idx <0
            raise TypeError("Index out of bound")
        end

        i = 0
        copy = @first

        while i != idx
            copy = copy.pnext
            i += 1
        end

        copy.value = to
    end
end

class Sort
    def self.BubbleSort(xs)
        if ! xs.kind_of? LinkedList
            raise TypeError
        end

        n = xs.len

        for i in (0...n)
            for j in (0...n-i-1)
                if xs.get(j) > xs.get(j+1)
                    xs.swap(j, j+1)
                end
            end
        end
    end

    def self.InsertSort(xs)

        for i in (1...xs.len)
            key = xs.get(i)

            j = i-1
            while j >= 0 && key < xs.get(j)
                xs.set(j+1, xs.get(j))
                j -= 1
            end
            xs.set(j+1, key)
        end
    end
end

lista = LinkedList.new()
lista.insert(1)
lista.insert(10)
lista.insert(9)
lista.insert(3)
lista.insert(2)

lista2 = LinkedList.new()
lista2.insert(1)
lista2.insert(10)
lista2.insert(9)
lista2.insert(3)
lista2.insert(2)

puts "Original list"
puts lista
puts ""

timeAstart = Time.now
Sort.BubbleSort(lista2)
puts "After Bubble Sort:"
puts(lista2)
timeAend = Time.now
puts "Time of Bubble Sort:"
deltaA = timeAend-timeAstart
puts deltaA
puts ""
timeBstart = Time.now
Sort.InsertSort(lista)
puts "After Insert Sort:"
puts(lista)
timeBend = Time.now
puts "Time of Insert Sort:"
deltaB = timeBend-timeBstart
puts deltaB

