# This file contains implemenation of a HashTable using a BST implemenation.
# The binary search tree implementation ensures logarithmic time for key operations such as insert and get.
$LOAD_PATH << '.'
require "bst_node.rb"
class BstDictionary
attr_accessor :root_node
	def initialize(key = nil,value =nil)
		puts "entered BstDictionary initialize"
		node_args = {:key => key, :value => value,:left => nil, :right => nil, :parent => nil}
		@root_node = BstNode::Node.new(node_args)
	end

	# Inserts a key value pair into the dictionary
	#
	# @param[key] the key corresponding to the input entry
	# @param[value] the value corresponding to the input entry
	# @return [V] the value of the old entry if the key already exists. Replaces old value with new value
	# 	      null if the entry does not yet exist
	attr_reader :key,:value
		attr_accessor :left, :right,:parent
	def insert(key,value)
		node_args = {:key => key, :value => value,:left => "March", :parent => "April"}
		return insert(node_args)
	end


	# Returns the entry corresponding to the key 
	#
	# @param[key] the key corresponding to the entry to remove
	# 	     null if the entry does not exist
	def get(key)
	end

	# Removes the entry corresponding to the key 
	#
	# @param[key] the key corresponding to the entry to remove
	# @return [V] the value of the entry to remove
	# 	      null if the entry does not  exist
	def remove
	end



	# Removes all the entries from the dictionary
	def clear
	end

	# Returns the current size of the dictionary. Thus how many entries the dictionary holds.
	def size
		return @size
	end

private
	def insert(root_node, new_node)
		if (node == null)
			return null
		end

		if(root_node.key == new_node.key)
			root_node.value = nnew_ode.value
		end

		if(@root_node.key<= new_node.key)
			return insert(root_node.right, new_node.key)
		end


		if(@root_node.key> new_node.key)
			return insert(root_node.left, new_node.key)
		end

	end


	def key_equal?(root_key, new_key)

	end

	def initialize_tree()
	end

end