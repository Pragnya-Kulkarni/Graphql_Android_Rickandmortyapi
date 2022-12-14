// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.graphql

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.graphql.type.CustomType
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class GetCharacterQuery(
  val id: String
) : Query<GetCharacterQuery.Data, GetCharacterQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["id"] = this@GetCharacterQuery.id
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      writer.writeCustom("id", CustomType.ID, this@GetCharacterQuery.id)
    }
  }

  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = variables
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  data class Character(
    val __typename: String = "Character",
    /**
     * The id of the character.
     */
    val id: String?,
    /**
     * The name of the character.
     */
    val name: String?,
    /**
     * Link to the character's image.
     * All images are 300x300px and most are medium shots or portraits since they are intended to be
     * used as avatars.
     */
    val image: String?,
    /**
     * The gender of the character ('Female', 'Male', 'Genderless' or 'unknown').
     */
    val gender: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Character.__typename)
      writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, this@Character.id)
      writer.writeString(RESPONSE_FIELDS[2], this@Character.name)
      writer.writeString(RESPONSE_FIELDS[3], this@Character.image)
      writer.writeString(RESPONSE_FIELDS[4], this@Character.gender)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forCustomType("id", "id", null, true, CustomType.ID, null),
          ResponseField.forString("name", "name", null, true, null),
          ResponseField.forString("image", "image", null, true, null),
          ResponseField.forString("gender", "gender", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Character = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)
        val name = readString(RESPONSE_FIELDS[2])
        val image = readString(RESPONSE_FIELDS[3])
        val gender = readString(RESPONSE_FIELDS[4])
        Character(
          __typename = __typename,
          id = id,
          name = name,
          image = image,
          gender = gender
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Character> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    /**
     * Get a specific character by ID
     */
    val character: Character?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.character?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("character", "character", mapOf<String, Any>(
            "id" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "id")), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val character = readObject<Character>(RESPONSE_FIELDS[0]) { reader ->
          Character(reader)
        }
        Data(
          character = character
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "52519dbbda57ed507be833e004a12c89ee1d3d2ce39f6d6850b5482723c4e244"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query GetCharacter(${'$'}id:ID!) {
          |  character(id: ${'$'}id) {
          |    __typename
          |    id
          |    name
          |    image
          |    gender
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "GetCharacter"
    }
  }
}
