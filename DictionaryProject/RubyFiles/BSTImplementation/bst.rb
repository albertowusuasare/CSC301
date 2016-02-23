# This file contains implemenation of a HashTable using a BST implemenation.
# The binary search tree implementation ensures logarithmic time for key operations such as insert and get.
$LOAD_PATH << '.'
require "bst_node.rb"
class BstDictionary
	attr_accessor :root_node
	attr_reader  :size


	def initialize(key = nil,value =nil)
		@size = 0
		node_args = {:key => key, :value => value,:left => nil, :right => nil, :parent => nil}
		@root_node = BstNode::Node.new(node_args) unless value.nil?	
	end

	# Inserts a key value pair into the dictionary
	#
	# @param[key] the key corresponding to the input entry
	# @param[value] the value corresponding to the input entry
	# @return [V] the value of the old entry if the key already exists. Replaces old value with new value
	# 	      null if the entry does not yet exist

	def insert(key,value)
		node_args = {:key => key, :value => value,:left => nil, :right => nil, :parent => nil}
		new_node = BstNode::Node.new(node_args)
		if @root_node.nil?
			@root_node = new_node
			@size += 1
			return value
		end
		return insert_at_node(@root_node, new_node).value
	end


	# Returns the entry corresponding to the key 
	#
	# @param[key] the key corresponding to the entry to remove
	# 	     null if the entry does not exist
	def get(key)
		 node = get_at_node(key,@root_node);
		 return  (node.nil?) ? nil : node.value 
	end

	# Removes the entry corresponding to the key 
	#
	# @param[key] the key corresponding to the entry to remove
	# @return [V] the value of the entry to remove
	# 	      null if the entry does not  exist
	def remove (key)
		return remove_at_node(key,root_node)
	end



	# Removes all the entries from the dictionary
	def clear
		clear(@root_node)
	end

	# Returns the current size of the dictionary. Thus how many entries the dictionary holds.
	def size
		return @size
	end

	# Below are the helper methods for implementing the recursive algorithms for the core operations
	
	def clear_at_node(root_node)
		if(root_node == null)
			return
		end

		clear(root_node[:left])
		clear(root_node[:right])
		root_node = null;
	end

	def insert_at_node(root_node,new_node)
		if (root_node.nil?)
			root_node = new_node;
			@size += 1
			return root_node
		end

		#root_node_key = root_node[:key]
		#new_node_key = new_node[:key]

		root_node_key = root_node.key
		new_node_key = new_node.key

		if(root_node_key == new_node_key)
			root_node.value = new_node.value
			return root_node
		end

		if(root_node_key <= new_node_key)
			return insert_at_node(root_node.right,new_node)
		end

		if(root_node_key > new_node_key)
			return insert_at_node(root_node.left,new_node)
		end

	end

	def get_at_node(key, root_node)
		#puts "At get_at_node"
		if(root_node.nil?)
			puts "inside body of nil test "
			return  nil
		end

		
		#puts "Gets into body the first time"
		root_key = root_node.key

		if(key == root_key)
			return root_node
		end

		if key < root_key
		 return get(key,root_node.left)
		end

		if key > root_key
		 return get(key,root_node.right)
		end

	end

	def remove_at_node(key, root_node) 
		if root_node.nil?
			return root_node
		end
		root_key =root_node[:key]

		if(key < root_key)
			return remove(key, root_node[:left])
		end

		if(key > root_key)
			return remove(key,root_node[:right])
		end

		if hasTwoChildren
			min_val_right = findMin(root_node[:right])[:value]
			root_node[:value] = min_val_right
			remove(min_val_right,root_node[:right])
		end
	end

	def hasTwoChildren(root_node)
		return (root[:left] != null && root[:right] !=null)
	end

	def findMin_at_node(root_node)
		if(root_node == null)
			return root_node
		end
		findMin_at_node(root_node[:left])
	end

	def initialize_with_entry(key,value)
		insert(key,value)
	end
end