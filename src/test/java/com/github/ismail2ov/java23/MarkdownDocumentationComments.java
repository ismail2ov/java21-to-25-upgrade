package com.github.ismail2ov.java23;

import java.util.List;

public class MarkdownDocumentationComments {

    /// ## Inline Formatting
    /// - **Bold text** is created using double asterisks or double underscores
    /// - *Italic text* is created using single asterisks or single underscores
    /// - ***Bold and italic*** is created using triple asterisks
    /// - `Inline code` is created using backticks
    /// - <sub>Subscript</sub> is created using HTML sub tags
    /// - <sup>Superscript</sup> is created using HTML sup tags
    /// ~~~
    /// This is a block of source code
    /// ~~~
    /// ## Horizontal Rule
    /// A horizontal rule can be created using three or more asterisks or underscores:
    /// ***
    ///
    /// ## Escaping Special Characters
    /// You can escape special characters using a backslash:
    /// \*This text is not in italics\*
    ///
    /// @return A string indicating successful demonstration
    public String basicTextFormatting() {
        return "Basic text formatting demonstrated";
    }

    /// # Heading 1
    /// ## Heading 2
    /// ### Heading 3
    /// #### Heading 4
    /// ##### Heading 5
    /// ###### Heading 6
    ///
    /// Alternatively, you can use the following syntax for heading 1 and 2:
    ///
    /// Heading 1
    /// =========
    ///
    /// Heading 2
    /// ---------
    ///
    /// @param level The heading level to demonstrate (1-6)
    /// @return A string representation of the heading
    public String headingsExample(int level) {
        return "Heading level " + level + " demonstrated";
    }

    /// ## Unordered Lists
    /// - Item 1
    /// - Item 2
    ///   - Subitem 2.1
    ///   - Subitem 2.2
    /// - Item 3
    ///
    /// You can also use asterisks or plus signs:
    /// * Item A
    /// * Item B
    /// + Item X
    /// + Item Y
    ///
    /// ## Ordered Lists
    /// 1. First item
    /// 2. Second item
    ///    1. Subitem 2.1
    ///    2. Subitem 2.2
    /// 3. Third item
    ///
    /// ## Task Lists
    /// - [x] Completed task
    /// - [ ] Incomplete task
    /// - [x] Another completed task
    ///
    /// @param items The list of items to process
    /// @return A processed list of items

    public List<String> listsExample(List<String> items) {
        // Implementation details omitted
        return items;
    }
}
