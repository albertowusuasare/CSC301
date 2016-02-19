#This is a module for the Node of our binary search tree implementation for dictionaries
module BstNode
	class Node
		attr_accessor :key,:value
		attr_accessor :left, :right,:parent

		#@param [args] is a hash of the input attributes needed
		def initialize(args)
			puts "Entered Node initialize"
			if(args.size != 5)
				raise ArgumentError, "Argument Size must be 5"
				#throw :ArgumentError
			end
			@key = args[:key]
			@value = args[:value]
			@left = args[:left]
			@right = args[:right]
			@parent = args[:parent]
		end
	end
end