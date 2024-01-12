### VARIABLES ###

SRC_DIR = src
BUILD_DIR = build
OUT_DIR = out
DOC_DIR = doc
PKG = fr/iutfbleau/but2/sae322023
MAIN_PKG = main/$(PKG)
TEST_PKG = test/$(PKG)

CLASSPATH = $(BUILD_DIR)

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none -d $(BUILD_DIR) -cp $(CLASSPATH)

### TARGETS ###

build: tableur.jar

clean:
	rm -rf $(BUILD_DIR)/ $(OUT_DIR)/ tableur.jar $(DOC_DIR)/

doc:
	javadoc -d $(DOC_DIR) $(shell find $(SRC_DIR)/main -name "*.java") -cp $(CLASSPATH)

.PHONY: build clean doc classfiles

### RULES ###

tableur.jar: $(BUILD_DIR)/$(MAIN_PKG)/Main.class
	mkdir -p $(BUILD_DIR) $(OUT_DIR)
	jar cfm $(OUT_DIR)/tableur.jar $(SRC_DIR)/$(MAIN_PKG)/Manifest.txt -C $(BUILD_DIR) .


$(BUILD_DIR)/$(MAIN_PKG)/Main.class: $(SRC_DIR)/$(MAIN_PKG)/Main.java $(BUILD_DIR)/$(MAIN_PKG)/WindowController.class
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/WindowController.class: $(SRC_DIR)/$(MAIN_PKG)/WindowController.java $(BUILD_DIR)/$(MAIN_PKG)/WindowView.class $(BUILD_DIR)/$(MAIN_PKG)/Worksheet.class $(BUILD_DIR)/$(MAIN_PKG)/WorksheetController.class $(BUILD_DIR)/$(MAIN_PKG)/CellController.class
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/WindowView.class: $(SRC_DIR)/$(MAIN_PKG)/WindowView.java
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/WorksheetController.class: $(SRC_DIR)/$(MAIN_PKG)/WorksheetController.java $(BUILD_DIR)/$(MAIN_PKG)/WorksheetView.class $(BUILD_DIR)/$(MAIN_PKG)/Worksheet.class $(BUILD_DIR)/$(MAIN_PKG)/CellController.class $(SRC_DIR)/$(MAIN_PKG)/WindowController.java $(BUILD_DIR)/$(MAIN_PKG)/WindowView.class $(BUILD_DIR)/$(MAIN_PKG)/Cell.class
	$(JC) $(JCFLAGS) $(SRC_DIR)/$(MAIN_PKG)/WorksheetController.java $(SRC_DIR)/$(MAIN_PKG)/WindowController.java

$(BUILD_DIR)/$(MAIN_PKG)/Worksheet.class: $(SRC_DIR)/$(MAIN_PKG)/Worksheet.java $(SRC_DIR)/$(MAIN_PKG)/Cell.java
	$(JC) $(JCFLAGS) $(SRC_DIR)/$(MAIN_PKG)/Worksheet.java $(SRC_DIR)/$(MAIN_PKG)/Cell.java $(SRC_DIR)/$(MAIN_PKG)/CellView.java $(SRC_DIR)/$(MAIN_PKG)/ReferenceTreeNode.java $(SRC_DIR)/$(MAIN_PKG)/FormulaParser.java

$(BUILD_DIR)/$(MAIN_PKG)/CellController.class: $(SRC_DIR)/$(MAIN_PKG)/CellController.java $(BUILD_DIR)/$(MAIN_PKG)/CellView.class $(BUILD_DIR)/$(MAIN_PKG)/Cell.class
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/Cell.class: $(SRC_DIR)/$(MAIN_PKG)/Cell.java $(SRC_DIR)/$(MAIN_PKG)/Worksheet.java $(SRC_DIR)/$(MAIN_PKG)/CellView.java $(SRC_DIR)/$(MAIN_PKG)/ReferenceTreeNode.java $(BUILD_DIR)/$(MAIN_PKG)/TreeNode.class $(BUILD_DIR)/$(MAIN_PKG)/IncorrectFormulaException.class $(BUILD_DIR)/$(MAIN_PKG)/IncalculableFormulaException.class $(BUILD_DIR)/$(MAIN_PKG)/FormulaParser.class
	$(JC) $(JCFLAGS) $(SRC_DIR)/$(MAIN_PKG)/Cell.java $(SRC_DIR)/$(MAIN_PKG)/Worksheet.java $(SRC_DIR)/$(MAIN_PKG)/CellView.java $(SRC_DIR)/$(MAIN_PKG)/ReferenceTreeNode.java

$(BUILD_DIR)/$(MAIN_PKG)/CellView.class: $(SRC_DIR)/$(MAIN_PKG)/CellView.java $(SRC_DIR)/$(MAIN_PKG)/Cell.java
	$(JC) $(JCFLAGS) $(SRC_DIR)/$(MAIN_PKG)/CellView.java $(SRC_DIR)/$(MAIN_PKG)/Cell.java


$(BUILD_DIR)/$(MAIN_PKG)/TreeNode.class: $(SRC_DIR)/$(MAIN_PKG)/TreeNode.java $(BUILD_DIR)/$(MAIN_PKG)/IncalculableFormulaException.class
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/ReferenceTreeNode.class: $(SRC_DIR)/$(MAIN_PKG)/ReferenceTreeNode.java $(BUILD_DIR)/$(MAIN_PKG)/TreeNode.class $(SRC_DIR)/$(MAIN_PKG)/Cell.java $(BUILD_DIR)/$(MAIN_PKG)/IncalculableFormulaException.class
	$(JC) $(JCFLAGS) $(SRC_DIR)/$(MAIN_PKG)/ReferenceTreeNode.java $(SRC_DIR)/$(MAIN_PKG)/Cell.java

$(BUILD_DIR)/$(MAIN_PKG)/IncorrectFormulaException.class: $(SRC_DIR)/$(MAIN_PKG)/IncorrectFormulaException.java
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/IncalculableFormulaException.class: $(SRC_DIR)/$(MAIN_PKG)/IncalculableFormulaException.java
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/WorksheetView.class: $(SRC_DIR)/$(MAIN_PKG)/WorksheetView.java $(BUILD_DIR)/$(MAIN_PKG)/CellController.class
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/FormulaParser.class: $(SRC_DIR)/$(MAIN_PKG)/FormulaParser.java $(SRC_DIR)/$(MAIN_PKG)/Worksheet.java $(BUILD_DIR)/$(MAIN_PKG)/IncorrectFormulaException.class $(BUILD_DIR)/$(MAIN_PKG)/NumberTreeNode.class $(BUILD_DIR)/$(MAIN_PKG)/TreeNode.class $(BUILD_DIR)/$(MAIN_PKG)/AdditionTreeNode.class $(BUILD_DIR)/$(MAIN_PKG)/SubtractionTreeNode.class $(BUILD_DIR)/$(MAIN_PKG)/MultiplicationTreeNode.class $(BUILD_DIR)/$(MAIN_PKG)/DivisionTreeNode.class $(BUILD_DIR)/$(MAIN_PKG)/ReferenceTreeNode.class
	$(JC) $(JCFLAGS) $(SRC_DIR)/$(MAIN_PKG)/FormulaParser.java $(SRC_DIR)/$(MAIN_PKG)/Worksheet.java $(SRC_DIR)/$(MAIN_PKG)/Cell.java

$(BUILD_DIR)/$(MAIN_PKG)/AdditionTreeNode.class: $(SRC_DIR)/$(MAIN_PKG)/Worksheet.java
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/SubtractionTreeNode.class: $(SRC_DIR)/$(MAIN_PKG)/SubtractionTreeNode.java
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/MultiplicationTreeNode.class: $(SRC_DIR)/$(MAIN_PKG)/MultiplicationTreeNode.java
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/DivisionTreeNode.class: $(SRC_DIR)/$(MAIN_PKG)/DivisionTreeNode.java
	$(JC) $(JCFLAGS) $<

$(BUILD_DIR)/$(MAIN_PKG)/NumberTreeNode.class: $(SRC_DIR)/$(MAIN_PKG)/NumberTreeNode.java
	$(JC) $(JCFLAGS) $<