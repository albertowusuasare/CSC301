$LOAD_PATH << '.'
# file: test/test_calculator_basic.rb
  require 'minitest/autorun'
  require 'bst' # don't worry, this works

  class BstDictionaryTest < Minitest::Test

  def setup
  	puts "Entered Setup in test."
  	@dictionary = BstDictionary.new()
  end

  def test_initialization_success
  	assert(@dictionary ,"Assert that dictionary is initialized")
  end
  end