;;Dawid Holewa 317898
;Korzystam z definicji funkcji z listy 5

;Zmieniona jest free-vars : zwraca listę,
;w której są zmienne wolne, jak i ich negacje (jesli występują
;w formule)


;Pomysł polega na tym, że jeśli wszystkie klauzule
;są prawdziwe, to cnf nie jest falsifiable
;klauzule są tautologiami, jeżeli istnieje taki
;p, że w klauzuli znajduje się p i (neg p)


;Falsifiable, która sprawdza każde wartościowania
;sprawdza 2^(ilosc zmiennych w całym wyrażeniu)
;wartosciowan,
;podczas gdy
;falsifiable, która opiera się na strukturze cnf 
;przechodzi po całym cnf i dla każdej klazuli
; sprawdza tylko jeden warunek, opisany powyzej.

;Ta druga jest więc dużo bardziej efektywna
#lang racket

(require "props.rkt")
(provide falsifiable-cnf)


(define (prop? f)
  (or (var? f)
      (and (neg? f)
           (prop? (neg-subf f)))
      (and (conj? f)
           (prop? (conj-left f)))
      (and (disj? f)
           (prop? (disj-right f))
           (prop? (disj-left f)))))

(define (free-vars f)
  (cond
    [(var? f) (list f)]
    [(neg? f) (list f)]
    [(conj? f) (remove-duplicates (append (free-vars (conj-left f))
                                          (free-vars (conj-right f))))]
    [(disj? f) (remove-duplicates (append (free-vars (disj-left f))
                                          (free-vars (disj-right f))))]))

(define (literal? f)
  (or (var? f)
      (and (neg? f)
           (var? (neg-subf f)))))


(define (cnf? f)
  (cond
    [(literal? f) #t]
    [(neg? f) #f]
    [(conj? f) #t]
    [(disj? f) (and (cnf? (disj-left f))
                    (cnf? (disj-right f))
                    (not (conj? (disj-left f)))
                    (not (conj? (disj-right f))))]
    ))


(define (neg-to-nnf f)
  (cond
    [(var? f) (neg f)]
    [(neg? f) (convert-to-nnf (neg-subf f))]
    [(conj? f) (disj (neg-to-nnf (conj-left f))
                     (neg-to-nnf (conj-right f)))]
    [(disj? f) (conj (neg-to-nnf (disj-left f))
                     (neg-to-nnf (disj-right f)))]))

(define (convert-to-nnf f)
  (cond
    [(var? f) f]
    [(neg? f) (neg-to-nnf (neg-subf f))]
    [(conj? f) (conj (convert-to-nnf (conj-left f))
                     (convert-to-nnf (conj-right f)))]
    [(disj? f) (disj (convert-to-nnf (disj-left f))
                     (convert-to-nnf (disj-right f)))]))
    


(define (convert-to-cnf f)
  (cond
    [(var? f) f]
    [(neg? f) (convert-to-cnf (neg-to-nnf (neg-subf f)))]
    [(conj? f)
     (cond
       [(cnf? f) f]
       [else (conj (convert-to-cnf (conj-left f))
                   (convert-to-cnf (conj-right f)))]
       )]
    [(disj? f)
     (cond
       [(cnf? f) f]
       [(literal? (disj-left f)) (conj (convert-to-cnf (disj (disj-left f)
                                                             (conj-left (convert-to-cnf (disj-right f)))))
                                       (convert-to-cnf (disj (disj-left f)
                                                             (conj-right (convert-to-cnf (disj-right f))))))]
       [(literal? (disj-right f)) (conj (convert-to-cnf (disj (conj-left (convert-to-cnf (disj-left f)))
                                                              (disj-right f)))
                                        (convert-to-cnf (disj (conj-right (convert-to-cnf (disj-left f)))
                                                              (disj-right f))))]
       [else (conj (convert-to-cnf (disj (conj (disj-left (convert-to-cnf (disj-left f)))
                                               (disj-right (convert-to-cnf (disj-left f))))
                                         (disj-left (convert-to-cnf (disj-right f)))))
                                   (disj-right (convert-to-cnf (disj-right f))))])] 
    ))

;_______________________________________________

;sprawdza czy dla (neg p) istnieje odpowiednio p
(define (contain-both-literals?
         literal set)
  (cond [(empty? set) #f]
       [(neg? literal)
             (memq (neg-subf literal)
                   set)]
        [else #f]))

;sprawdza czy zbior zawiera chociaz jedną parę zmiennej
;i jej negacji
(define (has-both? set)
  (define original set)
  (define (aux set original)
    (cond [(empty? set) #f]
          [(null? (cdr set))
           (contain-both-literals? (car set)
                                   original)]
          [(if (contain-both-literals? (car set)
                                       original)
               #t
               (aux (cdr set) original))]
          [else #f]))
  (aux set original))
           

(define (falsifiable-cnf f)
  (define formula (convert-to-cnf f))
  (define (aux formula)
    (cond [(empty? formula) (error "Error")]
          [(= 1 (length (free-vars f))) #t]
          [(conj? formula)
           (or (aux (conj-left formula))
               (aux (conj-right formula)))]
          [else (if (has-both? (free-vars formula))
                    #f
                    #t)]))
  (aux formula))








(define f1
  (conj (neg 'p)
        'p))
(define f2
  (conj (disj 'p
              (neg 'p))
        'q))
(define f3
  (conj (disj 'p
              (neg 'p))
        (disj 'q
              (neg 'q))))
(define f4
  (conj f3
        'r))
(define f5
  (conj (disj 'p
              (neg 'p))
        (disj 'q
              (disj (neg 'q)
                    'r))))
(define f6
  (conj (disj 'p
              (neg 'p))
        (disj 'q
              'r)))

(define f7
  (conj (disj 'p
              (neg 'p))
        (disj 'q
              (neg 'r))))
(define f8
  (conj (disj 'q
              (disj 'r
                    's))
        (disj (neg 'q)
              (disj (neg 'r)
                    (neg 's)))))

(define f9
  (conj (conj-left f8)
        (disj 'p
              (neg 'p))))

(define f10
  (conj (disj 'q
              'r)
        (conj 'p
              (neg 'q))))

(define f11
  'p)

(define f12
  (disj 'p (neg 'p)))

(define f13
  (disj 'p
        (disj (neg 'p)
              'q)))


(falsifiable-cnf f1)
(falsifiable-cnf f2)
(falsifiable-cnf f3)
(falsifiable-cnf f4)
(falsifiable-cnf f5)
(falsifiable-cnf f6)
(falsifiable-cnf f7)
(falsifiable-cnf f8)
(falsifiable-cnf f9)
(falsifiable-cnf f10)
(falsifiable-cnf f11)
(falsifiable-cnf f12)
(falsifiable-cnf f13)