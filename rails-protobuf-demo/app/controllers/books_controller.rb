class BooksController < ApplicationController
  before_action :set_book, only: %i[ show update destroy ]

  # GET /books/1
  def show
    @book = Book.find(params[:id])
    @book.title = @book.title + "aaaaaaaa"
    response_data = Tsuyoyo::Protobuf::Demo::Book.new(
      id: 10,
      title: @book.title,
      author: Tsuyoyo::Protobuf::Demo::Author.new(
        id: 1,
        name: 'Author Taro',
        penName: 'Taro pen name',
      ),
      genre: Tsuyoyo::Protobuf::Demo::Genre::FANTASY,
    )

    response_encoded_data = Tsuyoyo::Protobuf::Demo::Book.encode(response_data)
    render plain: response_encoded_data
  end

  # POST /books
  def create
  end

  # PATCH/PUT /books/1
  def update
  end

  # DELETE /books/1
  def destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_book
      @book = Book.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def book_params
      params.require(:book).permit(:title, :body)
    end
end
