$LOAD_PATH << '.'
# file: test/test_calculator_basic.rb
  require 'minitest/autorun'
  require 'bst' # don't worry, this works

  class BstDictionaryTest < Minitest::Test

  def setup
  	@dictionary = BstDictionary.new()
  end

  def test_initialization_success
  	assert(@dictionary ,"Assert that dictionary is initialized")
  end

  def test_insert_unique_val
  	@dictionary = BstDictionary.new()
  	alphabets = ('a'..'z').to_a
  	alphabets.each do |x|
  		value = @dictionary.insert(x,x.ord)
  		assert(value = x)
  	end
  	#puts "Size of dictionary : " +@dictionary.size.to_s
  	assert(@dictionary.size == alphabets.length,"Assert that 26 items have been added to dictionary")
  end

   def test_insert_duplicate_val
   	my_dictionary = BstDictionary.new()

   	random_integer_key = Random.rand(10)
   	random_integer_value = Random.rand(10)
   	new_integer_value = random_integer_value - 1;

   	first_insert_val = my_dictionary.insert(random_integer_key,random_integer_value)
   	assert(first_insert_val == random_integer_value,"test_insert_duplicate: Assert first key added")
   #	puts "First insert val " + first_insert_val.to_s

   	second_insert_val = my_dictionary.insert(random_integer_key,new_integer_value)
   	#puts "Second_insert_val: " + second_insert_val.to_s
   	get_result = my_dictionary.get(random_integer_key)

   	#puts "Get result : " + get_result.to_s
   	assert(second_insert_val == get_result,"test_insert_duplicate: Assert second insertion replaces old value")
   end

   def test_get
   	my_dictionary = BstDictionary.new()
   	my_dictionary.insert('a',97)
   	get_result = my_dictionary.get('a')
   	assert(97 == get_result,"test_get: Assert  simple get case")
   end
  end