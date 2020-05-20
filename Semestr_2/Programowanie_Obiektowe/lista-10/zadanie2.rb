class Node
    @value
    @pprev
    @pnext
    def initialize(val)
        @value = val
        @pprev = nil
        @pnext = nil
    end

    def to_s()
        return "Node of value: " + @value.to_s
    end

    attr_accessor :value, :pprev, :pnext
end

class DoublyLinkedList
    @first
    @length
    @last

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
            if @first.value > newnode.value
                @last = @first
                @first = newnode
                @first.pnext = @last
                @last.pprev = @first
            else
                @last = newnode
                @first.pnext = @last
                @last.pprev = @first
            end
        else
            if @first.value > newnode.value
                newnode.pnext = @first
                @first.pprev = newnode
                @first = newnode

            elsif @last.value < newnode.value
                @last.pnext = newnode
                newnode.pprev = @last
                @last = @last.pnext

            else
                copy = @first
                while copy != nil
                    if copy.value > newnode.value
                        copy.pprev.pnext = newnode
                        newnode.pprev =  copy.pprev
                        newnode.pnext = copy
                        copy.pprev = newnode
                        break
                    end
                    copy = copy.pnext
                end
            end
        end
        @length += 1
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
end

class Search
    def self.BinarySearch(dllist, l, r, x)
        if !dllist.kind_of? DoublyLinkedList
            return ("Blad")
        end

        if r >= l
            mid = l + (r - l) / 2

            aux = dllist.get(mid)
            if aux == x
                return true
            elsif aux > x
                return self.BinarySearch(dllist, l, mid-1, x)
            else
                return self.BinarySearch(dllist, mid+1, r, x)
            end
        else
            return false
        end
    end

    def self.InterpolationSearch(arr, n, x)
        lo = 0
        hi = n-1

        while lo <= hi && x >= arr.get(lo) && x <= arr.get(hi)
            if lo == hi
                if arr.get(lo) == x
                    return true
                end
                return false
            end

            pos = lo + (((hi-lo).to_f / (arr.get(hi) - arr.get(lo))) * (x - arr.get(lo))).to_i

            if arr.get(pos) == x
                return true
            end

            if arr.get(pos) < x
                lo = pos + 1
            else
                hi = pos -1
            end
        end
        return false
    end
end



lista = DoublyLinkedList.new()
lista.insert(1)
lista.insert(3)
lista.insert(6)
lista.insert(2)
lista.insert(4)
lista.insert(0)
print(lista)

puts Search.BinarySearch(lista, 0, lista.len, 2)
puts Search.InterpolationSearch(lista, lista.len, 2)



