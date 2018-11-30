awk '!/^>/ { next } { getline seq } length(seq) >= 200 { print $0 "\n" seq }' input > output
