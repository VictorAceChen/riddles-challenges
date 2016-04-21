class Fixnum

  def factorial
    return 1 if self == 0
    (1..self).inject(1,&:*)
  end

end

def count_permutations(single , double, triple)
  (single + double + triple).factorial  /
    (single.factorial * double.factorial * triple.factorial)
end

def triple_combinations(single , double, triple)
  return 0 if single < 0
  count_permutations(single , double, triple) +
    triple_combinations(single - 3 , double, triple + 1)
end


def doubles_and_triple_combinations(single , double, triple)
  return 0 if single < 0

  count_permutations(single , double, triple) +
    doubles_and_triple_combinations(single - 2 , double + 1, triple) +
      triple_combinations(single - 3 , double, triple + 1)
end
# 1.factorial
# 3.factorial

def count_combinations_stair(n)
  doubles_and_triple_combinations(n , 0, 0)
end

# doubles_and_triple_combinations(5 , 0, 0)
#   doubles_and_triple_combinations(3 , 1, 0)
#   triple_combinations(2 , 0, 1)
