$LOAD_PATH << '.'
# file: test/test_calculator_basic.rb
  require 'minitest/autorun'
  require 'bst_node' # don't worry, this works

  class BstNodeTest < Minitest::Test

  def setup
  	node_args = {:key => "Albert", :value => nil,:left => nil, :right => nil, :parent => nil}
    #node_args = {:key => "Albert", :value => "Owusu-Asare",:left => "left", :right => "right", :parent => "parent"}
    @bstnode = BstNode::Node.new(node_args)
  end

  def test_initialization_success
  	assert(@bstnode ,"Assert that the node is initialized")
  end


def fields_set_test
    node_args = {:key => 97, :value => 'a',:left => nil, :right => nil, :parent => nil}
    #node_args = {:key => "Albert", :value => "Owusu-Asare",:left => "left", :right => "right", :parent => "parent"}
    @bstnode = BstNode::Node.new(node_args)
    assert_equal(97,@bstnode.key,"fields_set_test: assert key ")
    assert_equal('a',@bstnode.value,"fields_set_test: assert value")
end

  end