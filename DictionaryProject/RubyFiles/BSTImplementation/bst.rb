# This file contains implemenation of a HashTable using a BST implemenation.
# The binary search tree implementation ensures logarithmic time for key operations such as insert and get.
class BstDictionary

	# Inserts a key value pair into the dictionary
	#
	# @param[key] the key corresponding to the input entry
	# @param[value] the value corresponding to the input entry
	# @return [V] the value of the old entry if the key already exists. Replaces old value with new value
	# 	      null if the entry does not yet exist
	def insert(key,value)
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
	end

end